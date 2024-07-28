package jiraiyah.ugoo;

import jiraiyah.ugoo.registry.ModBlocks;
import me.shedaniel.rei.api.client.entry.filtering.base.BasicFilteringRule;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.item.ItemStack;

public class ModREIClientPlugin implements REIClientPlugin
{
    @Override
    public void registerBasicEntryFiltering(BasicFilteringRule<?> rule)
    {
        rule.hide(EntryStacks.of(ModBlocks.AIR_GOO_BOMB));
        rule.hide(EntryStacks.of(ModBlocks.CHUNK_GOO_BOMB));
        rule.hide(EntryStacks.of(ModBlocks.STONE_GOO_BOMB));
        REIClientPlugin.super.registerBasicEntryFiltering(rule);
    }
}