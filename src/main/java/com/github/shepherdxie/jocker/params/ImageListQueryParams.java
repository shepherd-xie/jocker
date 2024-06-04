package com.github.shepherdxie.jocker.params;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * API parameters for querying Docker images.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageListQueryParams {

    /**
     * Show all images. Only images from a final layer (no children) are shown by default.
     */
    private boolean all = false;

    /**
     * A JSON encoded value of the filters (a `map[string][]string`) to process on the images list.
     * Available filters:
     * - `before`=(`<image-name>[:<tag>]`,  `<image id>` or `<image@digest>`)
     * - `dangling=true`
     * - `label=key` or `label="key=value"` of an image label
     * - `reference`=(`<image-name>[:<tag>]`)
     * - `since`=(`<image-name>[:<tag>]`,  `<image id>` or `<image@digest>`)
     * - `until=<timestamp>`
     */
    private String filters;

    /**
     * Compute and show shared size as a `SharedSize` field on each image.
     */
    private boolean sharedSize = false;

    /**
     * Show digest information as a `RepoDigests` field on each image.
     */
    private boolean digests = false;
}
