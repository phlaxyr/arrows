package phlaxyr.largetents.machines;

import net.minecraft.block.material.Material;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import phlaxyr.largetents.LargeTents;
import phlaxyr.largetents.blocks.BlockCrafter;
import phlaxyr.largetents.client.gui.GuiID;
import phlaxyr.largetents.crafting.Craft5by5Manager;
import phlaxyr.largetents.crafting.ShapedRecipe5by5;
import phlaxyr.largetents.inventory.ContainerCrafterXbyX;
import phlaxyr.largetents.inventory.ICraftingPosTracker;
import phlaxyr.largetents.inventory.IPlayerSlotTracker;
import phlaxyr.largetents.machines.TemplateCrafter5by5.ContainerCrafter5by5;
import phlaxyr.largetents.machines.TemplateCrafter5by5.TileCrafter5by5;
import phlaxyr.largetents.tile.TileCrafter;

public class TemplateCrafter5by5 extends TemplateCrafter<
		TileCrafter5by5,
		ShapedRecipe5by5,
		ContainerCrafter5by5>{

	
	private static final ResourceLocation tex = 
			new ResourceLocation(LargeTents.MODID+":textures/gui/m_workbench_gui.png");
    public static final String UNLOCALIZED_NAME = "m_workbench", REGISTRY_NAME = "m_workbench";
	
	
	public TemplateCrafter5by5()
	{
		super(UNLOCALIZED_NAME, REGISTRY_NAME, "container.m_workbench.name", Material.WOOD, LargeTents.TAB, GuiID.CRAFTER_GUI,
				tex, 183, 197, 5, 5);
		
	}
	
	public BlockCrafter5by5 getNewBlock() {


		// mmmm so nice
		return new BlockCrafter5by5(this);
			
	}
	
	public static class BlockCrafter5by5 extends BlockCrafter<TileCrafter5by5>{
		protected BlockCrafter5by5(TemplateCrafter5by5 m) {
			super(m);
			
		}
		//TODO: public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos);
		@Override
		public boolean isOpaqueCube(IBlockState state) {return false;}
		
		@Override
		public boolean isFullCube(IBlockState state) {return false;}
	}
	
	@Override
	public TileCrafter5by5 getNewTile()
	{
		
		return new TileCrafter5by5();
	}

	public static class TileCrafter5by5 extends TileCrafter {

		public TileCrafter5by5()
		{
			super(5,5,"container.m_workbench.name");
		}
		
	    
	}

	
	
	@Override
	public Craft5by5Manager getManager()
	{
		return Craft5by5Manager.getInstance();
	}

	@Override
	public ContainerCrafter5by5 getNewContainer(InventoryPlayer inv, TileCrafter5by5 tile, World world, BlockPos pos)
	{
		// TODO Refactor codes into anonymous class or a static inner class
		return new ContainerCrafter5by5(inv, tile, world, pos, this);
	}
	

	
	public static class ContainerCrafter5by5 extends ContainerCrafterXbyX<TileCrafter5by5, ShapedRecipe5by5> {

		protected ContainerCrafter5by5(InventoryPlayer inv, TileCrafter5by5 tile, World world,
				BlockPos pos, TemplateCrafter5by5 m) {
			super(inv, tile, world, pos, 
					m.getManager(),
					m.getGridSlotLengthX(),
					m.getGridSlotLengthY(),
					ptracker,
					ctracker);
			
		}
		
		public static IPlayerSlotTracker ptracker = new IPlayerSlotTracker() {
	
			
			@Override
			public int bodyX() {
				
				return 12;
			}
			@Override
			public int bodyY() {
				
				return 109;
			}
			
		};
		public static ICraftingPosTracker ctracker = new ICraftingPosTracker() {
			@Override
			public int resultX() {
				
				return 143;
			}
			@Override
			public int resultY() {
				
				return 47;
			}
			@Override
			public int gridX() {
				
				return 21;
			}
			@Override
			public int gridY() {
				
				return 15;
			}
		};


	}
	
	/* No need to override this
	 * 
	@Override
	public GuiCrafterXbyX<TileCrafter5by5, DeprecatedContainerCrafter5by5> getGui(int textureSizeX, int textureSizeY,
			DeprecatedContainerCrafter5by5 cont)
	{
		// Refactor finished
		return new GuiCrafterXbyX<TileCrafter5by5, DeprecatedContainerCrafter5by5>(textureSizeX, textureSizeY, cont, tex);
	}*/

	@Override
	public boolean isInstanceOf(TileEntity te) {
		return te instanceof TileCrafter5by5;
	}




	

	

}