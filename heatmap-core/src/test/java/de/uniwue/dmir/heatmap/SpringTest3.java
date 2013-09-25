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

import java.io.IOException;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import de.uniwue.dmir.heatmap.core.IHeatmap;
import de.uniwue.dmir.heatmap.core.processing.ITileProcessor;
import de.uniwue.dmir.heatmap.core.processing.NonEmptyTileIterator;
import de.uniwue.dmir.heatmap.impl.core.data.type.external.ValuePixel;
import de.uniwue.dmir.heatmap.impl.core.data.type.internal.SumAndSize;

public class SpringTest3 {

	@Test
	@SuppressWarnings("unchecked")
	public void testHeatmap() throws IOException {
		
		ClassPathXmlApplicationContext appContext = 
				new ClassPathXmlApplicationContext(
						"spring/defaultApplicationContext.xml");
		
		IHeatmap<ValuePixel, SumAndSize> heatmap = 
				appContext.getBean(IHeatmap.class);
		
		NonEmptyTileIterator<ValuePixel, SumAndSize> tileIterator =
				appContext.getBean(NonEmptyTileIterator.class);

		ITileProcessor<ValuePixel, SumAndSize> heatmapFileWriter =
				appContext.getBean(ITileProcessor.class);
		
		tileIterator.iterate(heatmap, heatmapFileWriter);

		appContext.close();
	}
}