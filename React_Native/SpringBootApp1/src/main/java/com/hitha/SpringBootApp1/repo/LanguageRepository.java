package com.hitha.SpringBootApp1.repo;

import org.springframework.stereotype.Repository;

@Repository
public class LanguageRepository {
    public String findById(String languageId){
        if(languageId.equals("kan")){
            return "{\n" +
                    "    \"screens\":{\n" +
                    "        \"mainScreen\":{\n" +
                    "            \"search\":\"ಕಂಡುಹಿಡಿಯಿರಿ\",\n" +
                    "            \"myCrops\":\"ನನ್ನ ಬೆಳೆಗಳು\",\n" +
                    "            \"myMoney\":\"ನನ್ನ ಹಣ\",\n" +
                    "            \"myHarvest\":\"ನನ್ನ ಸುಗ್ಗಿ\",\n" +
                    "            \"home\":\"ಮನೆ\",\n" +
                    "            \"banking\":\"ಬ್ಯಾಂಕಿಂಗ್\",\n" +
                    "            \"knowledgeCenter\":\"ಜ್ಞಾನ ಕೇಂದ್ರ\",\n" +
                    "            \"account\":\"ಖಾತೆ\"\n" +
                    "        },\n" +
                    "        \"initial\":{\n" +
                    "            \"welcome\":{\n" +
                    "                \"next\":\"ಮುಂದೆ\"\n" +
                    "            },\n" +
                    "            \"signUp\":{\n" +
                    "                \"phoneNumber\":\"ದೂರವಾಣಿ ಸಂಖ್ಯೆ\",\n" +
                    "                \"next\":\"ಮುಂದೆ\",\n" +
                    "                \"otp\":\"ಒಟಿಪಿ\"\n" +
                    "            },\n" +
                    "            \"loginOrSignUp\":{\n" +
                    "                \"login\":\"ಲಾಗಿನ್\",\n" +
                    "                \"or\":\"ಅಥವಾ\",\n" +
                    "                \"signUp\":\"ಸೈನ್ ಅಪ್\"\n" +
                    "            }\n" +
                    "        }\n" +
                    "    }\n" +
                    "}";
        }
        else if(languageId.equals("eng")) {
            return "{\n" +
                    "    \"screens\":{\n" +
                    "        \"mainScreen\":{\n" +
                    "            \"search\":\"Search\",\n" +
                    "            \"myCrops\":\"My Crops\",\n" +
                    "            \"myMoney\":\"My Money\",\n" +
                    "            \"myHarvest\":\"My Harvest\",\n" +
                    "            \"home\":\"Home\",\n" +
                    "            \"banking\":\"Banking\",\n" +
                    "            \"knowledgeCenter\":\"Knowledge Center\",\n" +
                    "            \"account\":\"Account\"\n" +
                    "        },\n" +
                    "        \"initial\":{\n" +
                    "            \"welcome\":{\n" +
                    "                \"next\":\"Next\"\n" +
                    "            },\n" +
                    "            \"signUp\":{\n" +
                    "                \"phoneNumber\":\"Phone Number\",\n" +
                    "                \"next\":\"Next\",\n" +
                    "                \"otp\":\"OTP\"\n" +
                    "            },\n" +
                    "            \"loginOrSignUp\":{\n" +
                    "                \"login\":\"Login\",\n" +
                    "                \"or\":\"Or\",\n" +
                    "                \"signUp\":\"Sign Up\"\n" +
                    "            }\n" +
                    "        }\n" +
                    "    }\n" +
                    "}";
        }
        else if(languageId.equals("mar")) {
            return "{\n" +
                    "        \"screens\":{\n" +
                    "            \"mainScreen\":{\n" +
                    "                \"search\":\"शोधा\",\n" +
                    "                \"myCrops\":\"माझी पिके\",\n" +
                    "                \"myMoney\":\"माझे पैसे\",\n" +
                    "                \"myHarvest\":\"माझी कापणी\",\n" +
                    "                \"home\":\"मुख्यपृष्ठ\",\n" +
                    "                \"banking\":\"बँकिंग\",\n" +
                    "                \"knowledgeCenter\":\"ज्ञान केंद्रे\",\n" +
                    "                \"account\":\"खाते\"\n" +
                    "            },\n" +
                    "            \"initial\":{\n" +
                    "                \"welcome\":{\n" +
                    "                    \"next\":\"पुढे\"\n" +
                    "                },\n" +
                    "                \"signUp\":{\n" +
                    "                    \"phoneNumber\":\"फोन नंबर\",\n" +
                    "                    \"next\":\"पुढे\",\n" +
                    "                    \"otp\":\"ओ.टी.पी\"\n" +
                    "                },\n" +
                    "                \"loginOrSignUp\":{\n" +
                    "                    \"login\":\"लॉगिन\",\n" +
                    "                    \"or\":\"किंवा\",\n" +
                    "                    \"signUp\":\"साइन अप करा\"\n" +
                    "                }\n" +
                    "            }\n" +
                    "        }\n" +
                    "    }";
        }
        else if(languageId.equals("hin")) {
            return "else if(languageId.equals(\"marathi\")) {\n" +
                    "            return \"{\\n\" +\n" +
                    "                    \"        \\\"screens\\\":{\\n\" +\n" +
                    "                    \"            \\\"mainScreen\\\":{\\n\" +\n" +
                    "                    \"                \\\"search\\\":\\\"शोधा\\\",\\n\" +\n" +
                    "                    \"                \\\"myCrops\\\":\\\"माझी पिके\\\",\\n\" +\n" +
                    "                    \"                \\\"myMoney\\\":\\\"माझे पैसे\\\",\\n\" +\n" +
                    "                    \"                \\\"myHarvest\\\":\\\"माझी कापणी\\\",\\n\" +\n" +
                    "                    \"                \\\"home\\\":\\\"मुख्यपृष्ठ\\\",\\n\" +\n" +
                    "                    \"                \\\"banking\\\":\\\"बँकिंग\\\",\\n\" +\n" +
                    "                    \"                \\\"knowledgeCenter\\\":\\\"ज्ञान केंद्रे\\\",\\n\" +\n" +
                    "                    \"                \\\"account\\\":\\\"खाते\\\"\\n\" +\n" +
                    "                    \"            },\\n\" +\n" +
                    "                    \"            \\\"initial\\\":{\\n\" +\n" +
                    "                    \"                \\\"welcome\\\":{\\n\" +\n" +
                    "                    \"                    \\\"next\\\":\\\"पुढे\\\"\\n\" +\n" +
                    "                    \"                },\\n\" +\n" +
                    "                    \"                \\\"signUp\\\":{\\n\" +\n" +
                    "                    \"                    \\\"phoneNumber\\\":\\\"फोन नंबर\\\",\\n\" +\n" +
                    "                    \"                    \\\"next\\\":\\\"पुढे\\\",\\n\" +\n" +
                    "                    \"                    \\\"otp\\\":\\\"ओ.टी.पी\\\"\\n\" +\n" +
                    "                    \"                },\\n\" +\n" +
                    "                    \"                \\\"loginOrSignUp\\\":{\\n\" +\n" +
                    "                    \"                    \\\"login\\\":\\\"लॉगिन\\\",\\n\" +\n" +
                    "                    \"                    \\\"or\\\":\\\"किंवा\\\",\\n\" +\n" +
                    "                    \"                    \\\"signUp\\\":\\\"साइन अप करा\\\"\\n\" +\n" +
                    "                    \"                }\\n\" +\n" +
                    "                    \"            }\\n\" +\n" +
                    "                    \"        }\\n\" +\n" +
                    "                    \"    }\";\n" +
                    "        }";
        }


        else {
            throw new RuntimeException("NOT_FOUND");
        }
    }
}
