# Changelog v1.3

## Additions
- Added the item tag `lava_buckets`, containing:
  - Lava Bucket
- Added the item tag `powder_snow_buckets`, containing:
  - Powder Snow Bucket

## Changes
- Adapted fluid and powder snow pickup logic to support custom buckets by allowing them to be added to the corresponding mapping.
- Renamed `attaches_to_pane_and_bars` to `attaches_to_panes_and_bars`

## Fixes
- Fixed an issue where emptying a custom powder snow bucket would return a vanilla bucket.
- Fixed an issue where custom buckets could not be used to milk goats.