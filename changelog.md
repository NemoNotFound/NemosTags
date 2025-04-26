# Changelog v1.1

## Additions
- Added the block tag **all_glass_panes** to group all glass pane variants together.
- Added individual block tags for each stained glass pane color:
    - **brown_stained_glass_panes**
    - **blue_stained_glass_panes**
    - **light_blue_stained_glass_panes**
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

## Changes
- Iron bars and glass panes now attach to blocks in the **all_glass_panes** tag instead of just **glass_panes**.
- Walls now also attach to blocks in the **all_glass_panes** tag.
- Iron bars and glass panes now skip rendering between two blocks if both block states are found in the same tag.
  The following tags are considered for render skipping:
    - **glass_panes**
    - **brown_stained_glass_panes**
    - **blue_stained_glass_panes**
    - **light_blue_stained_glass_panes**
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