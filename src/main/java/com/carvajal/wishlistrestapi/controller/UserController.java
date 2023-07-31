package com.carvajal.wishlistrestapi.controller;

import com.carvajal.wishlistrestapi.dto.WishlistItemResponseDto;
import com.carvajal.wishlistrestapi.exception.ErrorMessage;
import com.carvajal.wishlistrestapi.service.WishlistItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;


@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Users", description = "Endpoints of the user handling")
@ApiResponses(
        value = {
                @ApiResponse(responseCode = "500", description = "Internal Server Error",
                        content = {@Content(mediaType = "application/json",
                                schema = @Schema(implementation = ErrorMessage.class))
                        }),
        }
)
public class UserController {
    private final WishlistItemService wishlistItemService;

    @GetMapping("/{user_id}/wishlist-items")
    @Operation(
            summary = "Get wishlist items by user id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Wishlist items returned successfully"),
                    @ApiResponse(responseCode = "404", description = "User not found",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ErrorMessage.class)),
                            }),
            }
    )
    public Set<WishlistItemResponseDto> getWishlistItemsByUserId(@PathVariable("user_id") UUID userId) {
        return wishlistItemService.getWishlistItemsByUserId(userId);
    }

}
