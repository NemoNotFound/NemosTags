# Changelog v1.2

## Additions
- Added the block tag `attaches_to_pane_and_bars`, containing tags:
  - `all_glass_panes`
  - `bars`
- Added the block tag `connects_to_wall`, containing tags:
  - `all_glass_panes`
  - `bars`
- Added the block tag `powered_rails`, containing:
  - Powered Rail
- Added the item tag `shears`, containing:
  - Shears
- Added the item tag `empty_buckets`, containing:
  - Bucket
- Added the item tag `water_buckets`, containing:
  - Water Bucket

## Changes
- Renamed ModBlockTags to NemosBlockTags (java class)
- Iron bars and glass panes now attach to blocks in the `attaches_to_pane_and_bars` tag instead of directly checking `all_glass_panes` and `bars`.
- Walls now connect to blocks in the `connects_to_wall` tag.
- The `all_glass_panes` tag now uses the individual pane tags as its default values.
- The redstone direction detection logic has been updated to check for blocks in the `powered_rails` block tag.
- When interacting with mushroom cows, sheep, snow golem, or bogged, the logic now checks if the held item is in the `shears` item tag.
- When using an item on a beehive, the logic now checks if the held item is in the `shears` item tag.
- When interacting with a cow, the logic now checks if the held item is in the `empty_buckets` item tag.
- The logic for emptying buckets has been updated to check if the filled bucket is in the `FILLED_BUCKET_TO_EMPTY_BUCKET` map and retrieve the corresponding empty bucket value from it.