package com.carvajal.wishlistrestapi.controller;

import com.carvajal.wishlistrestapi.dto.ItemResponseDto;
import com.carvajal.wishlistrestapi.dto.WishlistItemRequestDto;
import com.carvajal.wishlistrestapi.dto.WishlistItemResponseDto;
import com.carvajal.wishlistrestapi.exception.ErrorMessage;
import com.carvajal.wishlistrestapi.service.ItemService;
import com.carvajal.wishlistrestapi.service.WishlistItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/wishlist-items", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Wishlist items", description = "Endpoints associated to the wishlist items management")
@ApiResponses(
        value = {
                @ApiResponse(responseCode = "500", description = "Internal Server Error",
                        content = {@Content(mediaType = "application/json",
                                schema = @Schema(implementation = ErrorMessage.class))
                        }),
        }
)
public class WishlistItemController {

    private final WishlistItemService wishlistItemService;

    @PostMapping
    @Operation(
            summary = "Create a new wishlist item",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Items returned successfully")
            }
    )
    public ResponseEntity<WishlistItemResponseDto> createWishlistItem(@RequestBody WishlistItemRequestDto wishlistItemRequestDto) {
        return new ResponseEntity(wishlistItemService.createWishlistItem(wishlistItemRequestDto), HttpStatus.CREATED);
    }

}
