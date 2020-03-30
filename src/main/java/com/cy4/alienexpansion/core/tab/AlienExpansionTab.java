package com.cy4.alienexpansion.core.tab;

import com.cy4.alienexpansion.core.init.ItemInit;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class AlienExpansionTab extends ItemGroup{
	public static final ItemGroup ALIEN_EXPANSION = new AlienExpansionTab(ItemGroup.GROUPS.length, "alienexpansion");

	public AlienExpansionTab(int index, String label) {
		super(index, label);
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(ItemInit.PORTAL_TABLET.get());
	}
}
