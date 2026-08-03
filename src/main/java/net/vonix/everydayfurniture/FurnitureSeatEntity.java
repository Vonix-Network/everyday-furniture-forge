package net.vonix.everydayfurniture;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;

/** Invisible, non-persistent mount that keeps the player seated on the furniture seat. */
public final class FurnitureSeatEntity extends Entity {
    public FurnitureSeatEntity(EntityType<? extends FurnitureSeatEntity> type, Level level) { super(type, level); noPhysics = true; }
    @Override protected void defineSynchedData() { }
    @Override protected void readAdditionalSaveData(CompoundTag tag) { }
    @Override protected void addAdditionalSaveData(CompoundTag tag) { }
    @Override public Packet<?> getAddEntityPacket() { return NetworkHooks.getEntitySpawningPacket(this); }
    @Override public double getPassengersRidingOffset() { return 0.0; }
    @Override public void tick() {
        super.tick();
        if (!level.isClientSide && (getPassengers().isEmpty() || level.isEmptyBlock(blockPosition()))) discard();
    }
    @Override protected void addPassenger(Entity passenger) { super.addPassenger(passenger); passenger.setYRot(getYRot()); passenger.setYHeadRot(getYRot()); }
    @Override public void positionRider(Entity passenger) { super.positionRider(passenger); passenger.setPos(getX(), getY(), getZ()); clampYaw(passenger); }
    @Override public void onPassengerTurned(Entity passenger) { clampYaw(passenger); }
    @Override public Vec3 getDismountLocationForPassenger(LivingEntity passenger) { return super.getDismountLocationForPassenger(passenger).add(0, .25, 0); }
    private void clampYaw(Entity passenger) {
        passenger.setYBodyRot(getYRot());
        float wrapped = Mth.wrapDegrees(passenger.getYRot() - getYRot());
        float clamped = Mth.clamp(wrapped, -120.0F, 120.0F);
        passenger.yRotO += clamped - wrapped;
        passenger.setYRot(passenger.getYRot() + clamped - wrapped);
        passenger.setYHeadRot(passenger.getYRot());
    }
}
