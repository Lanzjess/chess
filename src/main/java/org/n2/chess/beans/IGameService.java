/*******************************************************************************
 * Copyright (c) 2011 Daniel Murygin.
 *
 * This program is free software: you can redistribute it and/or 
 * modify it under the terms of the GNU Lesser General Public License 
 * as published by the Free Software Foundation, either version 3 
 * of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,    
 * but WITHOUT ANY WARRANTY; without even the implied warranty 
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. 
 * If not, see <http://www.gnu.org/licenses/>.
 * 
 * Contributors:
 *     Daniel Murygin <dm[at]sernet[dot]de> - initial API and implementation
 ******************************************************************************/
package org.n2.chess.beans;

import java.util.List;

import org.n2.chess.beans.hibernate.Game;
import org.n2.chess.beans.hibernate.User;
import org.n2.chess.model.UserNotFoundException;

/**
 * @author Daniel Murygin <dm[at]sernet[dot]de>
 *
 */
public interface IGameService {

    List<Game> loadGames(User user);

    Game loadGame(Integer id);

    Game create(User userWhite, String loginBlack) throws UserNotFoundException;
    
    Game create(String loginWhite, User userblack) throws UserNotFoundException;
    
    Game createByEmail(User userWhite, String emailBlack) throws UserNotFoundException;
    
    Game createByEmail(String emailWhite, User userblack) throws UserNotFoundException;
    
    Game create(User userWhite, User userBlack);
    
    void updateGame(Game game);
    
}
