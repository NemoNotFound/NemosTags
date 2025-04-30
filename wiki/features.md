# Attach Custom Blocks to Glass Panes and Iron Bars
Blocks added to the `attaches_to_panes_and_bars` block tag will visually connect to glass panes and iron bars.

---

# Connect Custom Blocks to Walls
Blocks added to the `connects_to_wall` block tag will visually connect to walls.

---

# Skip Rendering of Glass Pane and Iron Bar Sides
The rendering logic has been updated to skip rendering between connected blocks if both blocks are in the same pane-related tag.

The following tags are currently considered:
- `bars`
- `glass_panes`
- `brown_stained_glass_panes`
- `light_blue_stained_glass_panes`
- `blue_stained_glass_panes`
- `cyan_stained_glass_panes`
- `red_stained_glass_panes`
- `black_stained_glass_panes`
- `yellow_stained_glass_panes`
- `orange_stained_glass_panes`
- `green_stained_glass_panes`
- `lime_stained_glass_panes`
- `purple_stained_glass_panes`
- `pink_stained_glass_panes`
- `magenta_stained_glass_panes`
- `light_gray_stained_glass_panes`
- `gray_stained_glass_panes`
- `white_stained_glass_panes`

---

# Add Custom Shears

To add custom shears, simply add your item to the `shears` item tag.  
Your shears will then be able to break and retrieve leaves.

**Fabric only:**  
This also enables your shears to interact with:
- Beehives
- Bogged
- Mushroom Cows
- Sheep
- Snow Golems

**Note:**  
To make your shears work with dispensers, you must register them manually.

---

# Add Custom Buckets

## Milking Cows and Goats
To allow milking with a custom bucket:
- Add your empty bucket item to the `empty_buckets` item tag
- Add a key-value pair (empty bucket → milk bucket) to the `BUCKET_TO_MILK_BUCKET` map

## Emptying Buckets
The logic for emptying filled buckets checks if the item is present in the `FILLED_BUCKET_TO_EMPTY_BUCKET` map and returns the corresponding empty bucket.

To support this with a custom bucket, add your filled bucket to the `FILLED_BUCKET_TO_EMPTY_BUCKET` map.

## Filling Buckets
The logic for filling buckets with vanilla fluids and powder snow checks the corresponding maps.

You can extend the following maps:
- `EMPTY_BUCKET_TO_WATER_BUCKET`
- `EMPTY_BUCKET_TO_LAVA_BUCKET`
- `EMPTY_BUCKET_TO_POWDER_SNOW_BUCKET`

**Note:**
- For cauldron interactions, see the `CauldronInteraction` class.
- For dispenser support, you need to register dispenser behaviors manually.
- To allow custom water buckets to pick up entities (like axolotls or fish), you must implement this behavior yourself.

---

# Custom Powered Rail Detection
**Fabric and Forge only:**  
The redstone direction detection logic now checks for blocks in the `powered_rails` block tag.