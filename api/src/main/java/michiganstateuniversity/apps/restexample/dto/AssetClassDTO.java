package michiganstateuniversity.apps.restexample.dto;

public class AssetClassDTO
{
    private int syscode;
    private String code;
    private String description;

    /**
     * @return the syscode
     */
    public int getSyscode() {
        return syscode;
    }

    /**
     * @param aSyscode the syscode to set
     */
    public void setSyscode(final int aSyscode) {
        syscode = aSyscode;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param aCode the code to set
     */
    public void setCode(final String aCode) {
        code = aCode;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param aDescription the description to set
     */
    public void setDescription(final String aDescription) {
        description = aDescription;
    }

}