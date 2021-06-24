package michiganstateuniversity.apps.restexample.dto;

public class AssetStandardDTO
{
    private int syscode;
    private String code;
    private String name;

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
     * @return the Name
     */
    public String getName() {
        return name;
    }

    /**
     * @param aName the name to set
     */
    public void setName(final String aName) {
        name = aName;
    }

}