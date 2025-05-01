# Add Custom Bars

By adding your custom bars to the `bars` block tag, most behavior will work automatically.

- All blocks in the `bars` tag are breakable with a pickaxe.
- Bars will automatically attach to other panes, bars, and walls.
- The rendering logic skips rendering between connected blocks if both are in the `bars` tag.

This ensures high compatibility with other custom bars that also use this tag.

---

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
- `stained_glass_panes/brown`
- `stained_glass_panes/light_blue`
- `stained_glass_panes/blue`
- `stained_glass_panes/cyan`
- `stained_glass_panes/red`
- `stained_glass_panes/black`
- `stained_glass_panes/yellow`
- `stained_glass_panes/orange`
- `stained_glass_panes/green`
- `stained_glass_panes/lime`
- `stained_glass_panes/purple`
- `stained_glass_panes/pink`
- `stained_glass_panes/magenta`
- `stained_glass_panes/light_gray`
- `stained_glass_panes/gray`
- `stained_glass_panes/white`

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
- Add your empty bucket item to the `buckets/empty` item tag
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