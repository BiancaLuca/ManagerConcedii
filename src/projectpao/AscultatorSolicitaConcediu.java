
package projectpao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import library.model.PanouSolicitaConcediu;
import library.model.User;

public class AscultatorSolicitaConcediu implements ActionListener
{
    private User user;

    public AscultatorSolicitaConcediu(User user) 
    {
        this.user = user;
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        PanouSolicitaConcediu psc = new PanouSolicitaConcediu(user);
    }
    
}
