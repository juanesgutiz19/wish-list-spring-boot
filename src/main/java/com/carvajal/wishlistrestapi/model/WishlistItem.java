package com.carvajal.wishlistrestapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Generated
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder(toBuilder = true)
@Entity
@Table(name = "wishlist_items")
public class WishlistItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "wishlist_items_id")
    private UUID wishlistItemsId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @Column(name = "note")
    private String note;

    @Column(name = "added_date", nullable = false)
    private LocalDateTime addedDate;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;
}
