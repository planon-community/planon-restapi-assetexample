package michiganstateuniversity.apps.restexample.query;

import com.planonsoftware.platform.backend.querybuilder.v3.IJoin;
import com.planonsoftware.platform.backend.querybuilder.v3.IQueryBuilder;
import com.planonsoftware.platform.backend.querybuilder.v3.IQueryDefinition;
import com.planonsoftware.platform.backend.querybuilder.v3.IQueryDefinitionContext;

public class AssetQuery implements IQueryDefinition
{
    @Override
    public void create(IQueryBuilder asset, IQueryDefinitionContext aContext) {
        
        IJoin property = asset.addLeftOuterJoin("PropertyRef");
        IJoin floor = asset.addLeftOuterJoin("FreeInteger1");
        IJoin floorCode = floor.addLeftOuterJoin("Code");
        IJoin floorProperty = floor.addLeftOuterJoin("PropertyRef");
        IJoin space = asset.addLeftOuterJoin("SpaceRef");
        IJoin spaceFloor = space.addLeftOuterJoin("FloorRef");
        IJoin spaceFloorCode = spaceFloor.addLeftOuterJoin("Code");
        IJoin department = asset.addLeftOuterJoin("DepartmentRef");
        IJoin assetGroup = asset.addLeftOuterJoin("ItemGroupRef");
        IJoin assetClassification = asset.addLeftOuterJoin("AssetClassificationRef");
        IJoin parent = asset.addLeftOuterJoin("ParentRef");
        IJoin standardAsset = asset.addLeftOuterJoin("BaseStandardAssetRef");
        IJoin status = asset.addLeftOuterJoin("RefBOStateUserDefined");
        IJoin propertyStatus = property.addLeftOuterJoin("RefBOStateUserDefined");
        IJoin type = asset.addLeftOuterJoin("RefBODefinitionUserDefined");
        IJoin manufacturer = asset.addLeftOuterJoin("FreeString35");
        IJoin attributeSet = asset.addLeftOuterJoin("AttributeDefinitionSetRef");
        IJoin createdBy = asset.addLeftOuterJoin("SysAccountRef");

        asset.addSearchField("Syscode", "syscode");
        asset.addSearchField("Code", "assetCode");
        asset.addSearchField("Name", "description");
        status.addSearchField("PnName", "status");
        assetGroup.addSearchField("Code", "assetGroup");
        assetClassification.addSearchField("Code", "assetClass");
        manufacturer.addSearchField("Name", "manufacturer");
        asset.addSearchField("Type", "model");
        asset.addSearchField("AssetTag", "assetTag");
        property.addSearchField("Code", "property");
        floorCode.addSearchField("Code", "floor");
        space.addSearchField("Code", "space");
        asset.addSelectField("Code");
        asset.addSelectField("Name", "AssetDescription");
        property.addSelectField("Syscode", "PropertySyscode");
        property.addSelectField("Code", "PropertyCode");
        property.addSelectField("Name", "CommonName");
        propertyStatus.addSelectField("Code", "PropertyStatus");
        property.addSelectField("FreeString3", "HazardousMaterials");
        floor.addSelectField("Syscode", "FloorSyscode");
        floorCode.addSelectField("Code", "FloorCode");
        floor.addSelectField("Name", "FloorName");
        floorProperty.addSelectField("Code", "FloorProperty");
        space.addSelectField("Syscode", "SpaceSyscode");
        space.addSelectField("Code", "SpaceCode");
        spaceFloorCode.addSelectField("Code", "SpaceFloor");
        department.addSelectField("Syscode", "DepartmentSyscode");
        department.addSelectField("Code", "DepartmentCode");
        department.addSelectField("CompositeCode", "DepartmentCodeGroup");
        department.addSelectField("Name", "DepartmentName");
        assetGroup.addSelectField("Syscode", "AssetGroupSyscode");
        assetGroup.addSelectField("Code", "AssetGroupCode");
        assetGroup.addSelectField("Name", "AssetGroupName");
        assetClassification.addSelectField("Syscode", "AssetClassificationSyscode");
        assetClassification.addSelectField("Code", "AssetClassificationCode");
        assetClassification.addSelectField("Name", "AssetClassificationName");
        asset.addSelectField("AssetTag", "AssetTagNumber");
        parent.addSelectField("Code", "MainAssetCode");
        parent.addSelectField("Name", "MainAssetDescription");
        standardAsset.addSelectField("Syscode", "StandardAssetSyscode");
        standardAsset.addSelectField("Code", "StandardAssetCode");
        standardAsset.addSelectField("Name", "StandardAssetName");
        asset.addSelectField("PhotoRef");
        status.addSelectField("Syscode", "StatusSyscode");
        status.addSelectField("Code", "StatusCode");
        status.addSelectField("Name", "StatusName");
        type.addSelectField("PnName", "boType");
        asset.addSelectField("Brand");
        asset.addSelectField("Type", "ModelName");
        manufacturer.addSelectField("Syscode", "ManufacturerSyscode");
        manufacturer.addSelectField("Code", "ManufacturerCode");
        manufacturer.addSelectField("Name", "ManufacturerName");
        asset.addSelectField("IsMissing");
        asset.addSelectField("FirstUsedDate", "InServiceDate");
        asset.addSelectField("Quantity");
        attributeSet.addSelectField("Syscode", "AttributeSetSyscode");
        attributeSet.addSelectField("Code", "AttributeSetCode");
        attributeSet.addSelectField("Name", "AttributeSetName");
        asset.addSelectField("Attributes");
        asset.addSelectField("IsSimple");
        asset.addSelectField("IsArchived");
        createdBy.addSelectField("Accountname", "CreatedBy");
        asset.addSelectField("SysInsertDateTime", "CreatedOn");
        asset.addSelectField("SysChangeDateTime", "ModifiedOn");
    }
   
    @Override
    public String getBOName() {
        return "BaseAsset";
    }
}