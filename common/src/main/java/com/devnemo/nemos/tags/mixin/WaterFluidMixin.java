package com.devnemo.nemos.tags.mixin;

import com.devnemo.nemos.tags.interfaces.CustomBucketItemGetter;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.WaterFluid;
import org.spongepowered.asm.mixin.Mixin;

import static com.devnemo.nemos.tags.helper.ItemReplacementMaps.EMPTY_BUCKET_TO_WATER_BUCKET;

@Mixin(WaterFluid.class)
public class WaterFluidMixin implements CustomBucketItemGetter {

    @Override
    public Item nemosTags$getFilledBucket(Item emptyBucket) {
        if (!EMPTY_BUCKET_TO_WATER_BUCKET.containsKey(emptyBucket)) {
            return Items.WATER_BUCKET;
        }

        return EMPTY_BUCKET_TO_WATER_BUCKET.get(emptyBucket);
    }
}
