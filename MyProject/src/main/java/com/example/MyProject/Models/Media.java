package com.example.MyProject.Models;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "media")
public class Media  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "media_id", nullable = false)
    private Long mediaId;

    @Column(name = "media_data")
    private byte[] mediaData;

    @Column(name = "media_link")
    private String mediaLink;

    @Column(name = "media_name")
    private String mediaName;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    public Media(String mediaLink, String mediaName, Long productId) {
        this.mediaLink = mediaLink;
        this.mediaName = mediaName;
        this.productId = productId;
    }

    public Media(byte[] bytes, String mediaName, Long productId) {
        this.mediaData = bytes;
        this.mediaName = mediaName;
        this.productId = productId;
    }

}