# Planon JAX-RS Asset Example

## Setup

1. You will not need to install any extra .jar files or add anything for this example. This all uses Planon base functionality.
2. You will need to create a new development workspace within your development environment. The name is crucial as it will be in your final URL as well as it will be in your app.json file.
3. When prompted for the module name I'd recommend naming it something other than module. I did api in my example. The reason for this is that it will show up in your final URL and module in a URL looks weird.
4. You will need to create classes and folders. Your hierarchy should look similar to the example, but replace michiganstateuniversity and apps with whatever is in your app.json file under partnerIdentifier.
5. When creating classes it helps to have a folder called dto (this is where you store your data models, getters and setters), a folder called query (this is where you store your queries) and a folder called service (this is where you store the services that the rest service calls).
6. When creating classes it is also important to note that you have to capitalize the first letter of the class name.
7. Finally, for every rest service you create like AssetRestService in this example you will need at a minimum a service class, a query class and a dto class. This example has multiple dto classes because in the final response I wanted to be able to show information about items that are related to the asset like for the property on the asset I wanted to show more information than just the code for the property.

## Making Calls to Your API

1. Once you have deployed your API you have to give a user group permissions within the Apps TSI.
2. When you make your call in a product like postman you will need a header with the following information:
    1. Key: Authorization
    2. Value: PLANONKEY accesskey=(Get this part by generating an access key for one of your accounts that is in the group you gave permissions to the App) 
3. Generating an accesskey can be done by going to the Accounts TSI, finding a user, going to the access keys under settings and adding one there. The full text of the Access key field is what is used in your value above.
4. For every API endpoint there are two possible URLs to call. Looking at the example below you'll notice the /sdk you can use services/sdk, but that URL is rate limited even with an access key. If you use a URL without services in it, you'll bypass rate limiting.
    1. https://msu-dev.planoncloud.com/sdk/platform/jaxrs/michiganstateuniversity/apps/restexample/api/asset?assetCode=007556

## API Documentation

This example API has one endpoint named asset with 4 methods. 2 out of 4 of the methods require you to provide the code of the asset.

### GET Asset Method - https://yourenvironment.planoncloud.com/sdk/platform/jaxrs/yourpartnerIdentifier/yourDevelopmentWorkspaceName/yourModuleName/asset

The GET Asset Method returns an array of records. The call has the following query parameters available to it with an example query parameter listed after it (please note that the case of the query parameter name does matter, but the order of use doesn't):

- assetCode – 007556 – Allows partial match 
- assetClass – 13_00_00 – Allows exact match 
- assetGroup – U – Allows exact match 
- assetTag – Test text – Allows partial match 
- description – Text – Allows partial match 
- floor – 01 – Allows exact match 
- manufacturer – Grainger – Allows exact match 
- model – Text – Allows partial match 
- property – 0086 – Allows exact match 
- space – A160A – Allows exact match 
- status – UsrDisposed – Allows exact match 
- syscode – 196 – Allows exact match

### POST Asset Method - https://yourenvironment.planoncloud.com/sdk/platform/jaxrs/yourpartnerIdentifier/yourDevelopmentWorkspaceName/yourModuleName/asset

The POST Asset Method allows the ability to create one record at a time. The following values are required in the body of your POST call when creating an asset (Please note in our environment the code is automatically generated hence why it is not required):

- property 
- assetGroup 

Below is a list of fields that can be filled in when creating an asset:

- Description – String – This cannot exceed 255 characters 
- Asset Classification – Integer – This value should be the syscode of the asset classification
- Asset Group – Integer – This value should be the syscode of the asset group
- Property – Integer – This value should be the syscode of the property
- Floor – Integer – This value should be the syscode of the floor 
- Space – Integer – This value should be the syscode of the space
- Manufacturer – Integer – This value should be the syscode of the manufacturer
- Model – String – This cannot exceed 30 characters 
- Asset Tag – String – This cannot exceed 100 characters
- In Service Date – Date-only – This should be provided in the form of EPOCH time in milliseconds like this example 1624541770000. 

### GET Asset by Code Method - https://yourenvironment.planoncloud.com/sdk/platform/jaxrs/yourpartnerIdentifier/yourDevelopmentWorkspaceName/yourModuleName/asset/assetCode

The GET Asset by Code Method allows the ability to retrieve one asset based on the asset code that has been provided. This is not the asset's syscode, but is instead the code found in the code field. The asset cdoe is required for retrieving the asset and if the asset cdoe being retrieve is not in the system then it will respond with a 404 not found error.

### PUT Asset by Code Method - https://yourenvironment.planoncloud.com/sdk/platform/jaxrs/yourpartnerIdentifier/yourDevelopmentWorkspaceName/yourModuleName/asset/assetCode

The PUT Asset by Code Method allows the ability to update various fields about the asset for which the asset code has been provided in the URL. The asset code is required for the method to function. Below is a list of fields that can be updated by the method:

- Code – String – This cannot exceed 100 characters and must be unique 
- Status – String – This should be the PnName of the status you want to transition to. Status changes must be done as a separate call all on their own. If you choose to update other fields along with status those must be done in a separate call from status. 
- Is Missing – Boolean – If you see is missing to true you must first send a call making the space be set to null. Then you can make a second call to update is missing to be true.
- Description – String – This cannot exceed 255 characters 
- Asset Classification – Integer – This value should be the syscode of the asset classification
- Asset Group – Integer – This value should be the syscode of the asset group
- Property – Integer – This value should be the syscode of the property
- Floor – Integer – This value should be the syscode of the floor 
- Space – Integer – This value should be the syscode of the space
- Manufacturer – Integer – This value should be the syscode of the manufacturer
- Model – String – This cannot exceed 30 characters 
- Asset Tag – String – This cannot exceed 100 characters
- In Service Date – Date-only – This should be provided in the form of EPOCH time in milliseconds like this example 1624541770000. 
- Attributes – Attributes require an attribute code, attribute value and attribute type to be provided to properly update (these values can be found from a GET call for an asset or by making other REST endpoints to retrieve the values to choose from for attribute code and value)

### Example Response for GET Asset by Code Method from Our environment

```console
{
    "syscode": 7152,
    "code": "007556",
    "description": "Desk",
    "property": {
        "syscode": 27667,
        "propertyCode": "0008",
        "commonName": "WILLS HOUSE",
        "status": "PR01"
    },
    "floor": {
        "syscode": 2730,
        "floorCode": "01",
        "name": "First Floor",
        "propertyCode": "0008"
    },
    "space": {
        "syscode": 63880,
        "spaceNumber": "101",
        "floorCode": "01"
    },
    "department": null,
    "assetGroup": {
        "syscode": 3559,
        "code": "G1020.10",
        "name": "Utility Demolition"
    },
    "assetClassification": {
        "syscode": 9264,
        "code": "11_31_13",
        "description": "Playground Surfaces"
    },
    "assetTag": "Asset Tag 23",
    "mainAsset": null,
    "standardAsset": null,
    "photo": null,
    "status": {
        "syscode": 1481,
        "code": "AS20",
        "name": "In Use"
    },
    "boType": "UsrAsset",
    "brand": null,
    "model": "base model",
    "manufacturer": {
        "syscode": 4,
        "code": "0002",
        "name": "Grainger"
    },
    "isMissing": false,
    "inServiceDate": 1601784000000,
    "quantity": null,
    "attributeSet": {
        "syscode": 84,
        "code": "TEST",
        "name": "Test"
    },
    "attributes": [
        {
            "code": "Amps",
            "value": 100015.2,
            "label": "Amps",
            "attributeType": "BIGDECIMAL"
        },
        {
            "code": "DateTime",
            "value": 1601918640000,
            "label": "Date Time",
            "attributeType": "DATETIME"
        },
        {
            "code": "GeneratorSize",
            "value": "Size of the generator",
            "label": "Generator Size",
            "attributeType": "STRING"
        },
        {
            "code": "NumberOfCircuits",
            "value": 15,
            "label": "# Of Circuits",
            "attributeType": "INTEGER"
        },
        {
            "code": "PadExpireDate",
            "value": 1601870400000,
            "label": "Pad Expiration Date",
            "attributeType": "DATE"
        },
        {
            "code": "Serves",
            "value": "This serves a ton of stuff. This is multiline data! This serves a ton of stuff.",
            "label": "Serves?",
            "attributeType": "MULTILINE"
        },
        {
            "code": "Time",
            "value": "08:42:15",
            "label": "Time test",
            "attributeType": "TIME"
        },
        {
            "code": "TypeOfGenerator",
            "value": {
                "label": "Combo",
                "code": "Combo"
            },
            "label": "Type Of Generator",
            "attributeType": "SINGLESELECT"
        }
    ],
    "isSimple": true,
    "isArchived": false,
    "createdBy": "MULESERVICE",
    "creationDate": 1600452645000,
    "modifiedOn": 1617265219000
}
```

## Questions
If you have any questions on this please reach out to Nathan Moore from Michigan State University @ nmoore@msu.edu.
