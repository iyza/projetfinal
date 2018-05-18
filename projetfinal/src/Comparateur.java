import Déchet.Déchets;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Created by bajlu1731402 on 2018-04-30.
 */
public class Comparateur implements Comparator<Déchets>, Serializable{

    @Override
    public int compare(Déchets o1, Déchets o2) {
        int masseVolumique = o1.getMasseVolumique() - o2.getMasseVolumique();

        return masseVolumique;
    }

}
