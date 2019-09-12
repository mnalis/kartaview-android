package com.telenav.osv.obd;

import android.util.SparseArray;
import com.telenav.osv.R;
import com.telenav.osv.common.model.base.OSCBaseActivity;
import com.telenav.osv.common.model.base.OSCBaseFragment;
import com.telenav.osv.common.toolbar.MenuAction;
import com.telenav.osv.common.toolbar.OSCToolbar;
import com.telenav.osv.common.toolbar.ToolbarSettings;

/**
 * Base fragment class for the OBD flow.
 * This class is provides a common toolbar appearance and functionality for all the OBD fragments
 */
public abstract class ObdBaseFragment extends OSCBaseFragment {

    @Override
    public ToolbarSettings getToolbarSettings(OSCToolbar oscToolbar) {
        return getToolbarSettings()
                .setNavigationIcon(R.drawable.vector_back_black)
                .setMenuResources(R.menu.menu_obd, getToolbarMenuAction())
                .build();
    }

    @Override
    public boolean handleBackPressed() {
        return false;
    }

    /**
     * The method defines the toolbar settings.
     * @return a {@code Builder} object with the settings for fragment's toolbar.
     */
    public abstract ToolbarSettings.Builder getToolbarSettings();

    /**
     * Creates the toolbar menu actions which are set on the right side of the toolbar.
     * @return an array containing the defined menu actions with custom click listeners.
     */
    private SparseArray<MenuAction> getToolbarMenuAction() {
        SparseArray<MenuAction> menuActionArray = new SparseArray<>();
        menuActionArray.append(R.id.close_button, () -> {
            if (getActivity() != null) {
                ((OSCBaseActivity) getActivity()).returnToRecordingScreen();
            }
        });
        return menuActionArray;
    }
}