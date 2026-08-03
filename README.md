# Everyday Furniture — Forge 1.18.2

## Version 1.4.0

Original everyday household furniture with actual pixel-art textures, reference-guided geometry, and working interactions.

This release replaces the original cube placeholders with original multi-element block models based on real-world furniture silhouettes: chairs have legs, seats, and backs; sofas have cushions, backs, and arms; tables have tops and legs; cabinetry has doors, trim, and handles; appliances have fronts, glass, handles, and controls; sinks have a rim, basin, drain, and faucet; and shelves/racks use open separated boards. Public furniture references were used for silhouette and proportion guidance only; no third-party textures or model files were copied.

### Functional furniture
- Persistent 27-slot storage on cabinets, fridges, counters, and other enclosed furniture.
- Seating: chair, sofa, bar stool, and toilet are mountable when right-clicked with an empty hand; the seat entity is server-authoritative and non-persistent.
- Lamp: right-click with a stick to toggle light level 14 on/off.
- Sink: right-click with a glass bottle to receive a water potion.
- Trash bin: right-click with an item to permanently discard that stack; empty-hand use gives guidance.
- Culinary Dragons bridge: oven, microwave, and coffee maker use Culinary Dragons-owned outputs when that optional mod is installed.

- `kitchen_shelf` is a shallow open wall shelf with three separate boards and thin side supports; it is decorative and intentionally not a cabinet/storage block.
- 22 original 16x16 pixel-art block textures included in the JAR.
- 22 shaped crafting recipes included.
- Block loot tables included so placed furniture drops itself.
- Models use the furniture mod's own namespace and textures; no copied Fairy Lights or Culinary Dragons resources remain.

## Compatibility
- Minecraft 1.18.2 / Forge 40.x / Java 17
- Client and dedicated server
- Culinary Dragons is optional and remains the owner of its foods, drinks, alcohol, recipes, and processing stations.

## Build
```bash
./gradlew clean build
```
The distributable JAR is written to `build/libs/everyday-furniture-forge-1.18.2-1.4.0+1.18.2.jar`.
