/**
 * Heatmap Framework - Core
 *
 * Copyright (C) 2013	Martin Becker
 * 						becker@informatik.uni-wuerzburg.de
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 */
package de.uniwue.dmir.heatmap;

import org.junit.Assert;
import org.junit.Test;

import de.uniwue.dmir.heatmap.point.sources.geo.GeoBoundingBox;
import de.uniwue.dmir.heatmap.point.sources.geo.IMapProjection;
import de.uniwue.dmir.heatmap.point.sources.geo.projections.MercatorMapProjection;

public class GeoTileRangeProviderTest {

	@Test
	public void fullRange() {
		
		GeoBoundingBox geoBoundingBox = new GeoBoundingBox(
				-180, -90, 180, 90);
		
		IMapProjection mapProjection = new MercatorMapProjection();
		
		GeoTileRangeProvider provider = 
				new GeoTileRangeProvider(geoBoundingBox, mapProjection);
	
		TileRange tileRange = provider.getTileRange(0);
		Assert.assertEquals(new TileRange(0,0,0,0), tileRange);

		tileRange = provider.getTileRange(1);
		Assert.assertEquals(new TileRange(0,1,0,1), tileRange);
		
		tileRange = provider.getTileRange(2);
		Assert.assertEquals(new TileRange(0,3,0,3), tileRange);
	}
	

	@Test
	public void topRight() {
		
		GeoBoundingBox geoBoundingBox = new GeoBoundingBox(
				0, 0, 180, 90);
		
		IMapProjection mapProjection = new MercatorMapProjection();
		
		GeoTileRangeProvider provider = 
				new GeoTileRangeProvider(geoBoundingBox, mapProjection);
	
		TileRange tileRange = provider.getTileRange(0);
		Assert.assertEquals(new TileRange(0,0,0,0), tileRange);

		tileRange = provider.getTileRange(1);
		Assert.assertEquals(new TileRange(1,1,0,1), tileRange);
		
		tileRange = provider.getTileRange(2);
		Assert.assertEquals(new TileRange(2,3,0,2), tileRange);
	}
	
	@Test
	public void bottomLeft() {
		
		GeoBoundingBox geoBoundingBox = new GeoBoundingBox(
				-180, -90, 0, 0);
		
		IMapProjection mapProjection = new MercatorMapProjection();
		
		GeoTileRangeProvider provider = 
				new GeoTileRangeProvider(geoBoundingBox, mapProjection);
	
		TileRange tileRange = provider.getTileRange(0);
		Assert.assertEquals(new TileRange(0,0,0,0), tileRange);

		tileRange = provider.getTileRange(1);
		Assert.assertEquals(new TileRange(0,1,1,1), tileRange);
		
		tileRange = provider.getTileRange(2);
		Assert.assertEquals(new TileRange(0,2,2,3), tileRange);
	}
	
}
