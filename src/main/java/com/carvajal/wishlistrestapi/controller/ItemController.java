package com.carvajal.wishlistrestapi.controller;

import com.carvajal.wishlistrestapi.dto.ItemDto;
import com.carvajal.wishlistrestapi.exception.ErrorMessage;
import com.carvajal.wishlistrestapi.service.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/items", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Items", description = "Endpoints related to the items handling")
@ApiResponses(
        value = {
                @ApiResponse(responseCode = "500", description = "Internal Server Error",
                        content = {@Content(mediaType = "application/json",
                                schema = @Schema(implementation = ErrorMessage.class))
                        }),
        }
)
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    @Operation(
            summary = "Get all items",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Items returned successfully")
            }
    )
    public ResponseEntity<List<ItemDto>> getAllItems() {
        return ResponseEntity.ok(itemService.findAllItems());
    }

}
