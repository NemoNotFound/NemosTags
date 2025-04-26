# Changelog v1.2

## Additions
- Added the block tag **attaches_to_pane_and_bars**, containing tags:
  - **all_glass_panes**
  - **bars**
- Added the block tag **connects_to_wall**, containing tags:
  - **all_glass_panes**
  - **bars**
- Added the block tag **powered_rails**, containing:
  - Powered Rail

## Changes
- Iron bars and glass panes now attach to blocks in the **attaches_to_pane_and_bars** tag instead of directly checking **all_glass_panes** and **bars**.
- Walls now connect to blocks in the **connects_to_wall** tag.
- The **all_glass_panes** tag now uses the individual pane tags as its default values.
- The redstone direction detection logic has been updated to check for blocks in the **powered_rails** block tag.