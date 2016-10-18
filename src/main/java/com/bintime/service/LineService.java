package com.bintime.service;

import com.bintime.to.LineDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Entry point to process data and transfer to repository.
 * It's a bridge between repository tier and controller tier.
 *
 * @author Krukovskiy Arthur
 *
 */
public interface LineService {

    /**
     * Parses file collection and transfer to repository to save.
     *
     * @param files
     */
    Integer saveLine(List<MultipartFile> files);

    /**
     * Gets all lines by request id.
     *
     * @param requestId
     * @return
     */
    List<LineDTO> getLinesByRequestId(int requestId);

}
