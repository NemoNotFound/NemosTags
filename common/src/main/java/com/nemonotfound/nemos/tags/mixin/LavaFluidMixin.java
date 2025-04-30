package com.nemonotfound.nemos.tags.mixin;

import com.nemonotfound.nemos.tags.interfaces.CustomBucketItemGetter;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.LavaFluid;
import org.spongepowered.asm.mixin.Mixin;

import static com.nemonotfound.nemos.tags.helper.ItemReplacementMaps.EMPTY_BUCKET_TO_LAVA_BUCKET;

@Mixin(LavaFluid.class)
public class LavaFluidMixin implements CustomBucketItemGetter {

    @Override
    public Item nemosTags$getFilledBucket(Item emptyBucket) {
        if (!EMPTY_BUCKET_TO_LAVA_BUCKET.containsKey(emptyBucket)) {
            return Items.LAVA_BUCKET;
        }

        return EMPTY_BUCKET_TO_LAVA_BUCKET.get(emptyBucket);
    }
}
