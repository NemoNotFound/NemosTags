# Attach Custom Blocks to Glass Panes and Iron Bars
Blocks added to the `attaches_to_pane_and_bars` block tag will visually connect to glass panes and iron bars.

---

# Connect Custom Blocks to Walls
Blocks added to the `connects_to_wall` block tag will visually connect to walls.

---

# Skip Rendering of Glass Pane or Iron Bars Sides
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

To add custom shears, simply add your shears item to the `shears` item tag.  
Your shears will now be able to destroy and retrieve leaves.

**Fabric only:**  
This will also allow your shears to be used on **beehives**, **bogged**, **mushroom cows**, **sheep**, and **snow golems**.

**Note:**  
For your shears to work with a dispenser, you need to register them manually.

---

# Add Custom Buckets

## Milk a Cow/Goat
To milk a cow or goat, simply:
- Add your empty bucket item to the `empty_buckets` item tag
- Add a key-value pair (empty bucket → milk bucket) to the `BUCKET_TO_MILK_BUCKET` map

## Empty Buckets
The logic for emptying buckets has been updated to check if the filled bucket is in the `FILLED_BUCKET_TO_EMPTY_BUCKET` map and retrieve the corresponding empty bucket value.  
To make your custom bucket empty, simply add your filled bucket to the `FILLED_BUCKET_TO_EMPTY_BUCKET` map.

**Note:**
- To make your custom buckets interact with cauldrons, check out the `CauldronInteraction` class.
- To make your custom water buckets able to pick up entities, you will need to adapt their logic manually.

---

# Custom Powered Rail Detection
- **Fabric and Forge only:**  
  The redstone direction detection logic has been updated to check for blocks in the `powered_rails` block tag.