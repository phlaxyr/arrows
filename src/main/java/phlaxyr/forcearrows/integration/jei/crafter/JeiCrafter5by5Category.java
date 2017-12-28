package phlaxyr.forcearrows.integration.jei.crafter;

import mezz.jei.api.IGuiHelper;
import net.minecraft.util.ResourceLocation;
import phlaxyr.forcearrows.ForceArrows;

public class JeiCrafter5by5Category extends JeiCrafterXbyXCategory{


	public JeiCrafter5by5Category(IGuiHelper guiHelper)
	{
		super(guiHelper, new ResourceLocation(ForceArrows.MODID, "textures/gui/jei/craftfivefive.png"), 5, 5);
	}



	@Override
	public String getBlockName()
	{
		return "craftfivefive";
	}

}