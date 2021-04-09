package de.srendi.advancedperipherals.common.blocks.base;

import de.srendi.advancedperipherals.common.container.base.BaseContainer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

public interface IHasInventory<T extends BaseContainer> {

    ITextComponent getDisplayName();

    T createContainer(int id, PlayerInventory playerInventory, BlockPos pos, World world);

    int getInvSize();
}
