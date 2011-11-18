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

import java.io.Serializable;

import org.n2.chess.beans.hibernate.Game;
import org.n2.chess.model.Board;
import org.n2.chess.model.Square;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Daniel Murygin <dm[at]sernet[dot]de>
 *
 */
@Component("board")
@Scope("session")
public class BoardBean implements Serializable {
    
    private Board board;
    
    private Square square;
    
    private Square source;
    
    private Square dest;
    
    @Autowired
    private IBoardService boardService;
    
    @Autowired
    private GameBean gameBean;
    
    /**
     * @return the board
     */
    public Board getBoard() {
        if(board==null) {
            board = createBoard();
        }
        return board;
    }
    
    /**
     * @return
     */
    private Board createBoard() {
        Game game = getGameBean().getSelectedGame();
        if(game!=null) {
            this.board = getBoardService().createBoard(game);
        }
        return this.board;
    }
    
    public void select() {
        if(getSquare()!=null) {
            if(getSource()==null || (getSource()!=null && getDest()!=null)) {
                setSource(getSquare());
                setDest(null);
                getBoard().setSource(getSource());
            } else {
                setDest(getSquare());
                getBoard().setDest(getDest());
            }
        }
    }
    
    /**
     * @return the square
     */
    public Square getSquare() {
        return square;
    }

    /**
     * @param square the square to set
     */
    public void setSquare(Square square) {
        this.square = square;
    }

    

    /**
     * @return the source
     */
    public Square getSource() {
        return source;
    }

    /**
     * @param source the source to set
     */
    public void setSource(Square source) {
        this.source = source;
    }

    /**
     * @return the dest
     */
    public Square getDest() {
        return dest;
    }

    /**
     * @param dest the dest to set
     */
    public void setDest(Square dest) {
        this.dest = dest;
    }

    /**
     * @return the boardService
     */
    public IBoardService getBoardService() {
        return boardService;
    }

    /**
     * @param boardService the boardService to set
     */
    public void setBoardService(IBoardService boardService) {
        this.boardService = boardService;
    }

    /**
     * @return the gameBean
     */
    public GameBean getGameBean() {
        return gameBean;
    }

    /**
     * @param gameBean the gameBean to set
     */
    public void setGameBean(GameBean gameBean) {
        this.gameBean = gameBean;
    }

    
    
    

}