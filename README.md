#Planon JAX-RS Asset Example

##Setup

1. You will not need to install any extra .jar files or add anything for this example. This all uses Planon base functionality.
2. You will need to create a new development workspace within your development environment. The name is crucial as it will be in your final URL as well as it will be in your app.json file.
3. When prompted for the module name I'd recommend naming it something other than module. I did api in my example. The reason for this is that it will show up in your final URL and module in a URL looks weird.
4. You will need to create classes and folders. Your hierarchy should look similar to the example, but replace michiganstateuniversity and apps with whatever is in your app.json file under partnerIdentifier.
5. When creating classes it helps to have a folder called dto (this is where you store your data models, getters and setters), a folder called query (this is where you store your queries) and a folder called service (this is where you store the services that the rest service calls).
6. When creating classes it is also important to note that you have to capitalize the first letter of the class name.
7. Finally, for every rest service you create like AssetRestService in this example you will need at a minimum a service class, a query class and a dto class. This example has multiple dto classes because in the final response I wanted to be able to show information about items that are related to the asset like for the property on the asset I wanted to show more information than just the code for the property.

##Making Calls to Your API

1. Once you have deployed your API you have to give a user group permissions within the Apps TSI.
2. When you make your call in a product like postman you will need a header with the following information:
    1. Key: Authorization
    2. Value: PLANONKEY accesskey=(Get this part by generating an access key for one of your accounts that is in the group you gave permissions to the App) 
3. Generating an accesskey can be done by going to the Accounts TSI, finding a user, going to the access keys under settings and adding one there. The full text of the Access key field is what is used in your value above.
4. For every API endpoint there are two possible URLs to call. Looking at the example below you'll notice the /sdk you can use services/sdk, but that URL is rate limited even with an access key. If you use a URL without services in it, you'll bypass rate limiting.
    1. https://msu-dev.planoncloud.com/sdk/platform/jaxrs/michiganstateuniversity/apps/restexample/api/asset?assetCode=007556

##API Documentation
