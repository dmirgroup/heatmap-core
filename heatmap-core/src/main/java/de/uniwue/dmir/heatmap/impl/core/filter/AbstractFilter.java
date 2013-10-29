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
package de.uniwue.dmir.heatmap.impl.core.filter;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.uniwue.dmir.heatmap.core.IFilter;
import de.uniwue.dmir.heatmap.core.IHeatmap.TileSize;
import de.uniwue.dmir.heatmap.core.data.type.IExternalData;
import de.uniwue.dmir.heatmap.core.tile.coordinates.TileCoordinates;

public abstract class AbstractFilter<E extends IExternalData, I> 
implements IFilter<E, I> {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void filter(
			Collection<E> dataPoints, 
			I tile, 
			TileSize tileSize,
			TileCoordinates tileCoordinates) {
		
		for (E dataPoint : dataPoints) {
			this.filter(dataPoint, tile, tileSize, tileCoordinates);
		}
	}
	
}
