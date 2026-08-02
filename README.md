# Everyday Furniture — Forge 1.18.2

## Version 1.3.0

Original everyday household furniture with actual pixel-art textures and working interactions.

### Functional furniture
- Persistent 27-slot storage: bedside table, cabinet, bookshelf, kitchen counter, fridge, kitchen island, wall cabinet, dishwasher, plate rack, and kitchen shelf.
- Seating: chair, sofa, bar stool, and toilet are mountable when right-clicked with an empty hand; the seat entity is server-authoritative and non-persistent.
- Lamp: right-click with a stick to toggle light level 14 on/off.
- Sink: right-click with a glass bottle to receive a water potion.
- Trash bin: right-click with an item to permanently discard that stack; empty-hand use gives guidance.
- Culinary Dragons bridge: oven, microwave, and coffee maker use Culinary Dragons-owned outputs when that optional mod is installed.

### Assets and recipes
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
The distributable JAR is written to `build/libs/everyday-furniture-forge-1.18.2-1.3.0+1.18.2.jar`.
