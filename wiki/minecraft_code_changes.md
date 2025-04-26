# Block Changes
## Iron Bars
- The attachment logic has been updated to allow attachment to blocks in the **bars** and **all_glass_panes** block tags.
- The rendering logic has been updated to skip rendering between connected blocks if both are in the same pane-related tag.
  The following tags are currently considered:
  - **glass_panes**
  - **brown_stained_glass_panes**
  - **light_blue_stained_glass_panes**
  - **blue_stained_glass_panes**
  - **cyan_stained_glass_panes**
  - **red_stained_glass_panes**
  - **black_stained_glass_panes**
  - **yellow_stained_glass_panes**
  - **orange_stained_glass_panes**
  - **green_stained_glass_panes**
  - **lime_stained_glass_panes**
  - **purple_stained_glass_panes**
  - **pink_stained_glass_panes**
  - **magenta_stained_glass_panes**
  - **light_gray_stained_glass_panes**
  - **gray_stained_glass_panes**
  - **white_stained_glass_panes**

## Glass Panes
- The attachment logic has been updated to allow attachment to blocks in the **bars** and **all_glass_panes** block tags.
- The rendering logic has been updated to skip rendering between connected blocks if both are in the same pane-related tag.

## Walls
- The connection logic has been updated to allow connection to blocks in the **bars** and **all_glass_panes** block tags.

---

# Entity Changes
## Zombie Villager
- The conversion progress calculation for zombie villagers now also checks for the **bars** block tag.