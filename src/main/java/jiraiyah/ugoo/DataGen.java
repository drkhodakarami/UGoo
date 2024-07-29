package jiraiyah.ugoo;

import jiraiyah.ugoo.datagen.ModBlockTagProvider;
import jiraiyah.ugoo.datagen.ModLootTableProvider;
import jiraiyah.ugoo.datagen.ModModelProvider;
import jiraiyah.ugoo.datagen.ModRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

import static jiraiyah.ugoo.Reference.logBackRGB256;

public class DataGen implements DataGeneratorEntrypoint
{
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator)
	{
		logBackRGB256("Generating Data", 255, 255, 0, 0, 155, 55);
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
	}
}