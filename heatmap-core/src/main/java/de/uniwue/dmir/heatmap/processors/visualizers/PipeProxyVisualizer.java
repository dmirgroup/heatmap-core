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
package de.uniwue.dmir.heatmap.processors.visualizers;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import de.uniwue.dmir.heatmap.IVisualizer;
import de.uniwue.dmir.heatmap.TileSize;
import de.uniwue.dmir.heatmap.tiles.coordinates.TileCoordinates;

/**
 * Draws {@link IVisualizer} output over one another. 
 * 
 * @author Martin Becker
 * 
 * @param <TTile> the tile type to process
 */
public class PipeProxyVisualizer<TTile> extends AbstractDebuggingVisualizer<TTile> {

	private List<IVisualizer<TTile>> visualizers;
	
	public PipeProxyVisualizer(
			IVisualizer<TTile> bottom,
			IVisualizer<TTile> top) {
		
		this.visualizers = 
				new ArrayList<IVisualizer<TTile>>();

		visualizers.add(bottom);
		visualizers.add(top);
	}
	
	public PipeProxyVisualizer(List<IVisualizer<TTile>> visualizers) {
		this.visualizers = visualizers;
	}

	@Override
	public BufferedImage visualizeWithDebuggingInformation(
			TTile tile,
			TileSize tileSize,
			TileCoordinates tileCoordinates) {

		if (this.visualizers == null) {
			return null;
		}
		
		BufferedImage stack = null;
		Graphics g = null;
		for (IVisualizer<TTile> v : this.visualizers) {
			BufferedImage layer = v.visualize(tile, tileSize, tileCoordinates);
			if (stack == null && layer != null) {
				stack = layer;
				g = layer.getGraphics();
			} else {
				g.drawImage(layer, 0, 0, 256, 256, null);
			}
		}
		
		return stack;
	}

}
