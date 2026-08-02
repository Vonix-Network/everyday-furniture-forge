package net.vonix.everydayfurniture;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;

/** Invisible, non-persistent mount used by chairs, sofas, stools, and toilets. */
public final class FurnitureSeatEntity extends Entity {
    public FurnitureSeatEntity(EntityType<? extends FurnitureSeatEntity> type, Level level) { super(type, level); noPhysics = true; }
    @Override protected void defineSynchedData() { }
    @Override protected void readAdditionalSaveData(CompoundTag tag) { }
    @Override protected void addAdditionalSaveData(CompoundTag tag) { }
    @Override public Packet<?> getAddEntityPacket() { return NetworkHooks.getEntitySpawningPacket(this); }
    @Override public void tick() { super.tick(); if (!level.isClientSide && getPassengers().isEmpty()) discard(); }
    @Override public void positionRider(Entity passenger) { passenger.setPos(getX(), getY() + .15, getZ()); }
}
