package br.org.cesar.projectnext.cloudtranscription;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CloudTranscriptionModel {
    private String fileName;
    private String downloadUri;
    private long size;

}
