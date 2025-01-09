from datasets import load_dataset
from transformers import AutoModelForSeq2SeqLM, AutoTokenizer, GenerationConfig, TrainingArguments, Trainer
import pandas as pd
import numpy as np
from peft import LoraConfig, get_peft_model, TaskType, PeftModel


class Language_Model:
    model_name=''#The name of the HuggingFace model
    dataset_name=''#The name of the HuggingFace dataset
    max_generative_tokens=''#The max number of tokens you want the model to generate
    prompt_start=''#The constant start of the prompt(Describe the purpose) 
    prompt_end=''#The constant end of the prompt(Short description of the result type) 
    prompt_column=''#The name of the column in the dataset which forms the part of the prompt
    desired_response_column=''#The name of the column in the dataset which forms the part of the desired response
    save_directory=''#Where you want the trained model to be saved
    training_args=object #The arguments to train the LM
    use_lora_peft:bool=False #Whether you want to use Lora parameter efficient fine tuning
    lora_config=object #The lora configuration object
    model = object #Model object
    tokenizer = object #Tokenizer object

    def __init__(self,
        model_name,
        dataset_name,
        max_generative_tokens,
        prompt_start,
        prompt_end,
        prompt_column,
        desired_response_column,
        save_directory='./my_trained_model',
        training_args = TrainingArguments(
            output_dir='./my_trained_model_run',
            overwrite_output_dir=True,
            learning_rate=1e-5,
            num_train_epochs=1,
            weight_decay=0.01,
            logging_steps=1,
            max_steps=1
        ),
        use_lora_peft:bool=False,
        lora_config=LoraConfig(
            r=32, # Rank
            lora_alpha=32,
            target_modules=["q", "v"],
            lora_dropout=0.05,
            bias="none",
            task_type=TaskType.SEQ_2_SEQ_LM # FLAN-T5
        )):
        
        self.model_name=model_name
        self.dataset_name=dataset_name
        self.max_generative_tokens=max_generative_tokens
        self.prompt_start=prompt_start
        self.prompt_end=prompt_end
        self.prompt_column=prompt_column
        self.desired_response_column=desired_response_column
        self.save_directory=save_directory
        self.training_args=training_args
        self.use_lora_peft:bool=use_lora_peft
        self.lora_config=lora_config
        
        self.set_model_and_tokenizer(self.model_name)

    

    #Set the model name as well as the model and tokenizer object
    def set_model_and_tokenizer(self,model_name):
        self.model_name=model_name
        self.model = AutoModelForSeq2SeqLM.from_pretrained(model_name)
        self.tokenizer = AutoTokenizer.from_pretrained(model_name)
        # if peft_model:
        #     self.model = PeftModel.from_pretrained(AutoModelForSeq2SeqLM.from_pretrained(model_name),model_id=model_name)
        #     self.tokenizer = AutoTokenizer.from_pretrained(model_name)
        # else:
        #     self.model = AutoModelForSeq2SeqLM.from_pretrained(model_name)
        #     self.tokenizer = AutoTokenizer.from_pretrained(model_name)
            

    #Train the given model    
    def train(self):
        print("Dataset Loading......")
        dataset = load_dataset(self.dataset_name)
        print("Dataset Loaded......")

        #Remove all the columns except the desired ones
        remove_columns_list = dataset.column_names["train"].copy()
        remove_columns_list.remove(self.prompt_column)
        remove_columns_list.remove(self.desired_response_column)
        dataset.remove_columns(remove_columns_list)
        
        print("Preprocessing and Tokenizing datset......")
        tokenized_dataset = dataset.map(self.__preprocess_input, batched=True)
        print("Preprocessing and Tokenizing datset complete......")

        #Prepare the arguments used for training


        trainer= object
        #Use lora if use_lora_peft is set to True
        if self.use_lora_peft:
            if self.lora_config:
                print("Using lora configuration")
                self.model=get_peft_model(self.model, self.lora_config)
                trainer = Trainer(
                    model=self.model,
                    args=self.training_args,
                    train_dataset=tokenized_dataset['train'],
                    eval_dataset=tokenized_dataset['validation']
                )
            else:
                print("Lora Configuration not provided. Using model without Lora")
                trainer = Trainer(
                    model=self.model,
                    args=self.training_args,
                    train_dataset=tokenized_dataset['train'],
                    eval_dataset=tokenized_dataset['validation']
                )            
        else:
            print("Using model without Lora")
            trainer = Trainer(
                model=self.model,
                args=self.training_args,
                train_dataset=tokenized_dataset['train'],
                eval_dataset=tokenized_dataset['validation']
            )   
        
        print("Training Model......")
        trainer.train()
        print("Model Trained......")
        print("Saving Model......")
        self.model.save_pretrained(self.save_directory)
        self.tokenizer.save_pretrained(self.save_directory)
        print("Model Saved......")
        
        
    #Preprocess the input with the prompt start and prompt end
    def __preprocess_input(self,example):
        start_prompt = f'{self.prompt_start}\n\n'
        end_prompt = f'\n\n{self.prompt_end}'
        prompt = [start_prompt + dialogue + end_prompt for dialogue in example[self.prompt_column]]
        example['input_ids'] = self.tokenizer(prompt, padding="max_length", truncation=True, return_tensors="pt").input_ids
        example['labels'] = self.tokenizer(example[self.desired_response_column], padding="max_length", truncation=True, return_tensors="pt").input_ids
        
        return example
    
    #Predict based on the given text and current model
    def predict(self,text):
        prompt=prompt = f"""
            {self.prompt_start}

            {text}

            {self.prompt_end}
        """
        input_ids = self.tokenizer(prompt, return_tensors="pt").input_ids
        model_outputs = self.model.generate(input_ids=input_ids, generation_config=GenerationConfig(max_new_tokens=self.max_generative_tokens, num_beams=1))
        model_text_output = self.tokenizer.decode(model_outputs[0], skip_special_tokens=True)
        print("Model Prediction:")
        print(model_text_output)

#Main method to predict or train using the model
def main():
    lm= Language_Model(
        model_name='google/flan-t5-large',
        dataset_name="knkarthick/dialogsum",
        max_generative_tokens=5,
        prompt_start="Please give the topic of the following text",
        prompt_end="Topic:",
        prompt_column="dialogue",
        desired_response_column="topic",
    )
    lm.train()
    lm.set_model_and_tokenizer('./my_trained_model')
    lm.predict('''No. A CPU retains the same ability to process data from the day it was made until the day it ceases to operate or is permanently deactivated.What happens is that the requirements of software increase over time, as software developers take advantage of advances in CPU, memory, and graphics technology. An older CPU will therefore have to do more work to run later generations of software, and will eventually get to the point where the demands of software are too formidable for it to handle.''')

if __name__ == "__main__":
    main()