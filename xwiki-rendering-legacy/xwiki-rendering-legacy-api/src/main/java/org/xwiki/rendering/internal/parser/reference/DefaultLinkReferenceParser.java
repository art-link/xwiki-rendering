/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.rendering.internal.parser.reference;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.xwiki.component.annotation.Component;
import org.xwiki.rendering.parser.ResourceReferenceParser;

/**
 * Similar to {@link org.xwiki.rendering.internal.parser.reference.DefaultResourceReferenceParser} but handles the
 * case where the resource type wasn't specified. In this case it tries to guess the type by first looking for a URL
 * and then considering it's a reference to a document.
 *
 * @version $Id$
 * @since 2.6M1
 * @deprecated starting with 5.1M1 each Syntax needs to have its own component extending AbstractLinkReferenceParser in
 *             order to control the list of ResourceReferenceTypeParser it supports
 */
@Component
@Named("link")
@Singleton
@Deprecated
public class DefaultLinkReferenceParser extends AbstractLinkReferenceParser
{
    /**
     * Default parser to parse typed resource references.
     */
    @Inject
    private ResourceReferenceParser defaultResourceReferenceParser;

    @Override
    protected ResourceReferenceParser getDefaultResourceReferenceParser()
    {
        return this.defaultResourceReferenceParser;
    }
}