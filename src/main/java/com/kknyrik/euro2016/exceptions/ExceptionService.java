package com.kknyrik.euro2016.exceptions;

import org.springframework.stereotype.Service;


@Service
public class ExceptionService {

    public static class PlayerNotFoundException extends GeneralException {

        public PlayerNotFoundException(String value) {
            super("player", value);
        }
    }

    public static class TeamNotFoundException extends GeneralException {
        public TeamNotFoundException(String value){
            super("team", value);
        }
    }

    public static class GameNotFoundException extends GeneralException{
        public GameNotFoundException(String value){
            super("game", value);
        }
    }

    public static class GroupNotFoundException extends GeneralException{
        public GroupNotFoundException(String value){
            super("group", value);
        }
    }

    public static class DuplicateTeamException extends GeneralException{
        public DuplicateTeamException(String value){
            super("team", value);
        }
    }

}
