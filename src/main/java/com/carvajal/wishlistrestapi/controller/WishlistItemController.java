package com.carvajal.wishlistrestapi.controller;

import com.carvajal.wishlistrestapi.dto.WishlistItemRequestDto;
import com.carvajal.wishlistrestapi.dto.WishlistItemResponseDto;
import com.carvajal.wishlistrestapi.dto.WishlistItemUpdateRequestDto;
import com.carvajal.wishlistrestapi.exception.ErrorMessage;
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

import java.net.URI;
import java.util.UUID;

import static org.springframework.web.util.UriComponentsBuilder.fromUriString;

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
                    @ApiResponse(responseCode = "201", description = "Items returned successfully"),
                    @ApiResponse(responseCode = "404", description = "User or item not found",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ErrorMessage.class)),
                            }),
            }
    )
    public ResponseEntity<Void> createWishlistItem(@RequestBody WishlistItemRequestDto wishlistItemRequestDto) {
        WishlistItemResponseDto wishlistItemResponseDto = wishlistItemService.createWishlistItem(wishlistItemRequestDto);
        URI location = fromUriString("/api/v1/wishlist-items")
                .path("/{id}")
                .buildAndExpand(wishlistItemResponseDto.getWishlistItemsId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{wishlistItemId}")
    @Operation(
            summary = "Update wishlist item",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Wishlist item updated successfully"),
                    @ApiResponse(responseCode = "404", description = "Wishlist item not found",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ErrorMessage.class)),
                            }),
            }
    )
    public ResponseEntity<WishlistItemResponseDto> updateWishlistItem(@RequestBody WishlistItemUpdateRequestDto wishlistItemUpdateRequestDto, @PathVariable UUID wishlistItemId) {
        return ResponseEntity.status(HttpStatus.OK).body(wishlistItemService.updateWishlistItem(wishlistItemUpdateRequestDto, wishlistItemId));
    }
}
