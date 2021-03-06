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

import de.uniwue.dmir.heatmap.TileSize;
import de.uniwue.dmir.heatmap.processors.pixeliterators.RelativeCoordinatesArrayKeyValueIteratorFactory;
import de.uniwue.dmir.heatmap.tiles.pixels.SumPixel;
import de.uniwue.dmir.heatmap.util.mapper.IMapper;

/**
 * @see GenericAlphaVisualizer
 * @author Martin Becker
 *
 */
public class SumArrayAlphaVisualizer
extends GenericAlphaVisualizer<SumPixel[], SumPixel> {

	public SumArrayAlphaVisualizer(TileSize tileSize) {
		super(
				new RelativeCoordinatesArrayKeyValueIteratorFactory<SumPixel>(
					tileSize.getWidth(), 
					tileSize.getHeight(), 
					false),
					new IMapper<SumPixel, Double>() {
						@Override
						public Double map(SumPixel object) {
							return object.getSum();
						}
					});
	}

}
