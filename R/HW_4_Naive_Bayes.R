df <- read.csv("titanic_project.csv", header=TRUE)
head(df)
#Remove the first column
df <- subset(df, select = -c(X))
head(df)
df$survived <- factor(df$survived)
df$pclass <- factor(df$pclass)
df$survived <- factor(df$survived)
#For some reason sex hasn't been taken as a factor on the professor's github
#df$sex <- factor(df$sex)
train <- df[1:900, ]
test <- df[901:nrow(df), ]
library(e1071)
system.time(nb1 <- naiveBayes(survived~., data=train))
p1 <- predict(nb1, newdata=test, type="class")
acc_nb=mean(p1==test$survived)
print(paste("accuracy naivebayes= ", acc_nb))
table(p1, test$survived)
true_positives <- sum(ifelse(pred==1 & test$survived==1, 1.0, 0.0))
false_positives <- sum(ifelse(pred==1 & test$survived==0, 1.0, 0.0))
true_negatives <- sum(ifelse(pred==0 & test$survived==0, 1.0, 0.0))
false_negatives <- sum(ifelse(pred==0 & test$survived==1, 1.0, 0.0))
sensitivity <- true_positives/(true_positives+false_negatives)
specificity <- true_negatives/(true_negatives+false_positives)
print(paste("Sensitivity Naive Baye's= ", sensitivity))
print(paste("Specificity Naive Baye's= ", specificity))

