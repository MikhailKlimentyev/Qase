package models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestSuite {

    private String title;
    @SerializedName("parent_id")
    private int parentId;
    private String description;
    private String preconditions;
}
