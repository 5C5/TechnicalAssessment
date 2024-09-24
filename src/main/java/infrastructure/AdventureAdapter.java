package infrastructure;

import application.port.AdventurePort;
import domain.Adventure;
import domain.Move;
import domain.Position;

import java.util.List;

public class AdventureAdapter implements AdventurePort {
    private final FileOpener fileOpener;
    private final String defaultAdventureName;

    public AdventureAdapter(FileOpener fileOpener, String defaultAdventureName) {
        this.fileOpener = fileOpener;
        this.defaultAdventureName = defaultAdventureName;
    }

    @Override
    public Adventure chooseAdventure(String adventureName) {
        List<String> lines;
        try {
            lines = fileOpener.readFile(adventureName);
        } catch (UnreadableFile e) {
            lines = fileOpener.readResource(defaultAdventureName);
        }
        Position startingPosition = PositionFactory.findPosition(lines.get(0));
        List<Move> moves = MoveFactory.findMoves(lines.get(1));
        return new Adventure(startingPosition, moves);
    }
}
