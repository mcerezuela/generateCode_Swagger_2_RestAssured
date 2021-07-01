# generateCode_Swagger_2_RestAssured
We are using the Swagger Codegen Maven Plugin to generate the Rest Assured code for the demo petstore

First we download the petstore json

curl https://petstore.swagger.io/v2/swagger.json -o src/main/resources/petstore.json

We add to our project the swagger maven plugin at
https://github.com/swagger-api/swagger-codegen/tree/v2.4.21/modules/swagger-codegen-maven-plugin

*NOTE* We are not Using Version 3.0.0 because it does NOT support Rest Assured Libraries (currently at 3.0.25)
We proceed to generate the source code

'mvn clean generate-sources'

This will generate the following Tree:

'-> tree src'

\SRC
├───main
│   ├───java
│   │   └───com
│   │       └───smashtik
│   │           └───petstore
│   │               └───client
│   │                   ├───api
│   │                   └───model
│   └───resources
└───test
    └───java
        └───com
            └───smashtik
                └───petstore
                    └───client
                        └───api





