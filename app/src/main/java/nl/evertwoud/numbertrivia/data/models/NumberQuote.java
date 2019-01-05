package nl.evertwoud.numbertrivia.data.models;

import com.google.gson.annotations.SerializedName;

public class NumberQuote {

    @SerializedName("text")
    private String text;
    @SerializedName("number")
    private Integer number;
    @SerializedName("found")
    private Boolean found;
    @SerializedName("type")
    private String type;

    public String getText() {
        return text;
    }

    public Integer getNumber() {
        return number;
    }

    public Boolean getFound() {
        return found;
    }

    public String getType() {
        return type;
    }

    public void setText(String pText) {
        text = pText;
    }

    public void setNumber(Integer pNumber) {
        number = pNumber;
    }

    public void setFound(Boolean pFound) {
        found = pFound;
    }

    public void setType(String pType) {
        type = pType;
    }
}
