package pojos;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "status",
        "line_nbr",
        "date",
        "old_exp_shp_date",
        "new_exp_shp_date",
        "adj_exp_shp_date",
        "note_type",
        "brand"
})

public class Shipment {
    @JsonProperty("status")
    private String status;
    @JsonProperty("line_nbr")
    private String lineNbr;
    @JsonProperty("date")
    private String date;
    @JsonProperty("old_exp_shp_date")
    private String oldExpShpDate;
    @JsonProperty("new_exp_shp_date")
    private String newExpShpDate;
    @JsonProperty("adj_exp_shp_date")
    private String adjExpShpDate;
    @JsonProperty("note_type")
    private String noteType;
    @JsonProperty("brand")
    private String brand;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("line_nbr")
    public String getLineNbr() {
        return lineNbr;
    }

    @JsonProperty("line_nbr")
    public void setLineNbr(String lineNbr) {
        this.lineNbr = lineNbr;
    }

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("old_exp_shp_date")
    public String getOldExpShpDate() {
        return oldExpShpDate;
    }

    @JsonProperty("old_exp_shp_date")
    public void setOldExpShpDate(String oldExpShpDate) {
        this.oldExpShpDate = oldExpShpDate;
    }

    @JsonProperty("new_exp_shp_date")
    public String getNewExpShpDate() {
        return newExpShpDate;
    }

    @JsonProperty("new_exp_shp_date")
    public void setNewExpShpDate(String newExpShpDate) {
        this.newExpShpDate = newExpShpDate;
    }

    @JsonProperty("adj_exp_shp_date")
    public String getAdjExpShpDate() {
        return adjExpShpDate;
    }

    @JsonProperty("adj_exp_shp_date")
    public void setAdjExpShpDate(String adjExpShpDate) {
        this.adjExpShpDate = adjExpShpDate;
    }

    @JsonProperty("note_type")
    public String getNoteType() {
        return noteType;
    }

    @JsonProperty("note_type")
    public void setNoteType(String noteType) {
        this.noteType = noteType;
    }

    @JsonProperty("brand")
    public String getBrand() {
        return brand;
    }

    @JsonProperty("brand")
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
