package michiganstateuniversity.apps.restexample;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.GenericEntity;

import com.planonsoftware.jaxrs.api.v9.context.IJaxRsResourceContext;
import com.planonsoftware.platform.data.v1.ActionNotFoundException;
import com.planonsoftware.platform.data.v1.AttributeNotFoundException;
import com.planonsoftware.platform.data.v1.BusinessException;
import com.planonsoftware.platform.data.v1.FieldNotFoundException;
import com.planonsoftware.platform.data.v1.IDataService;

import michiganstateuniversity.apps.restexample.dto.AssetDTO;
import michiganstateuniversity.apps.restexample.dto.AssetCreateDTO;
import michiganstateuniversity.apps.restexample.dto.AssetUpdateDTO;
import michiganstateuniversity.apps.restexample.service.AssetService;

@Path("/asset")
public class AssetRestService
{

    @Context 
    IJaxRsResourceContext jaxrsContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAssets(@QueryParam("syscode") Integer syscode, @QueryParam("assetCode") String assetCode, @QueryParam("description") String description, @QueryParam("status") String status, @QueryParam("assetGroup") String assetGroup, @QueryParam("assetClass") String assetClass, @QueryParam("manufacturer") String manufacturer, @QueryParam("model") String model, @QueryParam("assetTag") String assetTag, @QueryParam("property") String property, @QueryParam("floor") String floor, @QueryParam("space") String space) throws IllegalStateException, ActionNotFoundException, IOException {
      
        System.out.println("Planon getAssets method execution started.");            
        
        IDataService dataService = jaxrsContext.getDataService();
        AssetService service = new AssetService();
        ArrayList<AssetDTO> assets = new ArrayList<AssetDTO>();
        
        Response response = null;

		try {
			assets = service.getAssets(dataService, syscode, assetCode, description, status, assetGroup, assetClass, manufacturer, model, assetTag, property, floor, space);
		} catch (FieldNotFoundException | BusinessException e) {		
			e.printStackTrace();
		}

        GenericEntity<List<AssetDTO>> assetsResponse = new GenericEntity<List<AssetDTO>>(assets) {};
        response = Response.ok(assetsResponse).build();          
 
        System.out.println("Planon getAssets method execution ended.");
        return response;
    }

    @GET
    @Path("/{assetCode}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAssetDetails(@PathParam("assetCode") String assetCode) throws IllegalStateException, ActionNotFoundException, IOException {
      
        System.out.println("Planon getAsset method execution started. assetCode : " +assetCode);            
        
        IDataService dataService = jaxrsContext.getDataService();
        AssetService service = new AssetService();
        AssetDTO asset = null;
        Response response = null;

		try {
			asset = service.getAssetByCode(dataService, assetCode);
		} catch (FieldNotFoundException | BusinessException e) {		
			System.out.println(e);
            e.printStackTrace();
		}

        if(asset == null) {
            response = Response.status(Response.Status.NOT_FOUND).build();
        } else {            
            response = Response.ok().entity(asset).build();
        }          
 
        System.out.println("Planon getAsset method execution ended.");
        return response;
    }

    @PUT
    @Path("/{assetCode}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateAsset(@PathParam("assetCode") String assetCode, AssetUpdateDTO aAsset) throws IllegalStateException, ActionNotFoundException, IOException, AttributeNotFoundException, ParseException {

        System.out.println("Planon resource updateAsset method execution started. assetCode : " + assetCode); 

        IDataService dataService = jaxrsContext.getDataService();
        AssetService service = new AssetService();
        AssetUpdateDTO asset = null;     
        Response response = null;

        try {
            asset = service.getAssetUpdateByCode(dataService, assetCode);
        } catch (FieldNotFoundException | BusinessException e) {
            e.printStackTrace();
        }

        if(asset == null) {
            response = Response.status(Response.Status.NOT_FOUND).build();
        } else {

            try {
                asset.setCode(aAsset.getCode());
                asset.setDescription(aAsset.getDescription());
                asset.setMainAsset(aAsset.getMainAsset());
                asset.setStatus(aAsset.getStatus());
                asset.setIsMissing(aAsset.getIsMissing());
                asset.setAssetClassification(aAsset.getAssetClassification());
                asset.setAssetGroup(aAsset.getAssetGroup());
                asset.setProperty(aAsset.getProperty());
                asset.setFloor(aAsset.getFloor());
                asset.setSpace(aAsset.getSpace());
                asset.setManufacturer(aAsset.getManufacturer());
                asset.setModel(aAsset.getModel());
                asset.setAssetTag(aAsset.getAssetTag());
                asset.setInServiceDate(aAsset.getInServiceDate());
                asset.setAttributes(aAsset.getAttributes());

                service.updateAssetDetailRecord(dataService, asset);
                response = Response.ok().build();
            } catch (ActionNotFoundException | FieldNotFoundException | BusinessException e) {
                System.out.println(e);
                response = Response.serverError().build();
            } 
        }          

        System.out.println("Planon resource updateAsset method execution ended.");
        return response;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createAsset(AssetCreateDTO asset) throws IllegalStateException, IOException {

        System.out.println("Planon resource createAsset method execution started."); 

		IDataService dataService = jaxrsContext.getDataService();
        AssetService service = new AssetService(); 
        Response response = null;
        AssetDTO assetResponse = null;      

        try {
            assetResponse = service.createAssetDetailRecord(dataService, asset);
            response = Response.ok().entity(assetResponse).build();
        } catch (ActionNotFoundException | FieldNotFoundException | BusinessException e) {
            System.out.println(e);
            response = Response.serverError().build();
        }           

        System.out.println("Planon resource createAsset method execution ended.");
        return response;
    }

}